CREATE TABLE Users (
   user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   user_name VARCHAR(50) NOT NULL,
   email VARCHAR(255) NOT NULL UNIQUE,
   password VARCHAR(255) NOT NULL,
   profile_pic VARCHAR(255) NOT NULL,
   created_at DATETIME NOT NULL,
   FCM_token VARCHAR(255) NOT NULL,
   profile_color TINYINT NOT NULL
);

INSERT INTO Users (user_name, email, password, profile_pic, created_at, FCM_token, profile_color)
VALUES ('apple','apple@example.com', '123',   'https://cdn.pixabay.com/photo/2014/02/01/17/28/apple-256261__480.jpg',
         NOW(), 'fcm_token_example_string',  1);

CREATE TABLE MainCategory (
  category_id INT NOT NULL AUTO_INCREMENT,
  category_name VARCHAR(50) NOT NULL,
  user_id INT NULL,  -- NULL 表示系統預設分類，此處允許 NULL
  is_default BOOLEAN NOT NULL DEFAULT FALSE, -- 除了旅行外 其他預設為 FALSE
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (category_id),
  FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

INSERT INTO MainCategory (category_name, user_id, is_default, created_at, updated_at)
VALUES ('旅行', NULL, TRUE, NOW(), NOW());

CREATE TABLE SubCategory (
 sub_category_id INT NOT NULL AUTO_INCREMENT,
 sub_category_name VARCHAR(50) NOT NULL,
 category_id INT NOT NULL,
 is_default BOOLEAN NOT NULL DEFAULT FALSE, -- 除了原本的旅行外子類別外 其他預設為 FALSE
 created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
 updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 category_icon VARCHAR(50) NOT NULL,
 PRIMARY KEY (sub_category_id),
 FOREIGN KEY (category_id) REFERENCES MainCategory(category_id)
);

INSERT INTO SubCategory (sub_category_name, category_id, is_default, created_at, updated_at, category_icon)
VALUES ('食物', 1, TRUE, NOW(), NOW(), 'icon_food');

CREATE TABLE `Groups`
(
    group_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    group_name VARCHAR(20) NOT NULL,
    group_color TINYINT, -- 圖像背景色 (0: Blue70, 1: Peach80, 2: BlueGray60)
    created_by INT NOT NULL,
    created_at DATETIME NOT NULL,
    settled_at DATETIME NOT NULL,
    currency VARCHAR(3) NOT NULL, -- 群組幣別 (EX: USD, TWD)
    currency_rate_type TINYINT NOT NULL DEFAULT 0, -- 匯率類型 (預設0, 0: 即時匯率, 1: 自訂匯率)
    main_category_id INT NOT NULL,
    sub_category_id INT NOT NULL,
    status INT NOT NULL DEFAULT 0, -- 群組狀態 (預設0, 0: 可編輯, 1: 已結算(不可編輯))

    CONSTRAINT fk_groups_created_by
        FOREIGN KEY (created_by) REFERENCES Users(user_id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT fk_groups_main_category
        FOREIGN KEY (main_category_id) REFERENCES MainCategory(category_id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT fk_groups_sub_category
        FOREIGN KEY (sub_category_id) REFERENCES SubCategory(sub_category_id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

INSERT INTO `Groups` (group_id, group_name, group_color, created_by, created_at, settled_at,
                currency, currency_rate_type, main_category_id, sub_category_id, status)
VALUES (1, 'TIP101', 0, 1, NOW(),
    NOW(), 'TWD', 0, 1,
    1, 0);
