INSERT INTO user (use_name, use_email, use_password)
  VALUES ('lars', 'lars@somehost.com', '$2a$10$UopG5zHB55MTuPQiS5q2yuEPJtsy53.tPy1hGXT53CBWhwjcZWwsW');
INSERT INTO user (use_name, use_email, use_password)
  VALUES ('rudy', 'rudy@somehost.com', '$2a$10$slxOL6AKBoM8nQdbBobBaeIudBLOzbudxCupriH1JD2Hi7QYpFbPG');
INSERT INTO user (use_name, use_email, use_password)
  VALUES ('marcel', 'marcel@somehost.com', '$2a$10$D2HqiFbG8fjTxxIbncRfT.rR8JHxexejnDZN5N0RPyvbG8WeyiMJe');
INSERT INTO user (use_name, use_email, use_password)
  VALUES ('jos', 'jos@somehost.com', '$2a$10$ORvD9KB8tR3CHfofFagdweuvzeuanL2ZjExryYCXdXYLeFsKFNha.');
INSERT INTO user (use_name, use_email, use_password)
  VALUES ('pedro', 'pedro@somehost.com', '$2a$10$nUU/rK7cxdllPS2pkDwKF.MZKpwvG2McoY905ks5/8b1Mn4ewacj6');

INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Hoe laat is het?', 'Graag zo snel mogelijk antwoord!', 20, '2016-08-30 14:47:00',
          SELECT use_id FROM user WHERE use_name = 'lars');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Hoe werkt Spring?', 'Graag zo snel mogelijk antwoord!', 16, '2016-08-30 11:34:00',
          SELECT use_id FROM user WHERE use_name = 'jos');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Wat is Gradle?', 'Graag zo snel mogelijk antwoord!', 45, '2016-08-30 10:29:00',
          SELECT use_id FROM user WHERE use_name = 'rudy');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Waarom gebruiken we geen Maven?', 'Graag zo snel mogelijk antwoord!', 10, '2016-08-30 18:18:00',
          SELECT use_id FROM user WHERE use_name = 'marcel');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Wat is een repository?', 'Graag zo snel mogelijk antwoord!', 9, '2016-08-30 05:41:00',
          SELECT use_id FROM user WHERE use_name = 'pedro');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Hoe werkt de @Component tag?', 'Graag zo snel mogelijk antwoord!', 78, '2016-08-30 14:22:00',
          SELECT use_id FROM user WHERE use_name = 'lars');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Hoe werkt de @Bean tag?', 'Graag zo snel mogelijk antwoord!', 34, '2016-08-30 16:00:00',
          SELECT use_id FROM user WHERE use_name = 'jos');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Wat is een controllers?', 'Graag zo snel mogelijk antwoord!', 65, '2016-08-30 09:43:00',
          SELECT use_id FROM user WHERE use_name = 'rudy');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Hoe kan ik in Thymeleaf X Y Z doen?', 'Graag zo snel mogelijk antwoord!', 12, '2016-08-30 00:34:00',
          SELECT use_id FROM user WHERE use_name = 'marcel');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Wat is de standaard directory structuur van een Maven/Gradle project?', 'Graag zo snel mogelijk antwoord!', 4, '2016-08-30 21:15:00',
          SELECT use_id FROM user WHERE use_name = 'pedro');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Help, mijn SpEL expressie werkt niet...', 'Graag zo snel mogelijk antwoord!', 55, '2016-08-30 15:12:00',
          SELECT use_id FROM user WHERE use_name = 'lars');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Waar kan ik de Tomcat log files vinden?', 'Graag zo snel mogelijk antwoord!', 24, '2016-08-30 16:35:00',
          SELECT use_id FROM user WHERE use_name = 'jos');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Hoe configureer ik Spring MVC?', 'Graag zo snel mogelijk antwoord!', 14, '2016-08-30 13:45:00',
          SELECT use_id FROM user WHERE use_name = 'rudy');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Hoe zet ik mijn project om naar Spring Boot?', 'Graag zo snel mogelijk antwoord!', 62, '2016-08-30 17:08:00',
          SELECT use_id FROM user WHERE use_name = 'marcel');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Mijn .war file werkt niet.... Help! :(', 'Graag zo snel mogelijk antwoord!', 30, '2016-08-30 10:45:00',
          SELECT use_id FROM user WHERE use_name = 'pedro');

INSERT INTO question_answer (qa_body, qa_score, qa_timestamp, qa_use_id, qa_parent_qa_id)
  VALUES ('Het antwoord is 5.', 5, '2016-08-30 21:45:00',
          SELECT use_id FROM user WHERE use_name = 'marcel',
          10);
INSERT INTO question_answer (qa_body, qa_score, qa_timestamp, qa_use_id, qa_parent_qa_id)
  VALUES ('Zie https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html', 3, '2016-08-30 21:59:00',
          SELECT use_id FROM user WHERE use_name = 'jos',
          10);
INSERT INTO question_answer (qa_body, qa_score, qa_timestamp, qa_use_id, qa_parent_qa_id)
  VALUES ('ok thx', 0, '2016-08-30 22:45:00',
          SELECT use_id FROM user WHERE use_name = 'pedro',
          10);

INSERT INTO question_answer (qa_body, qa_score, qa_timestamp, qa_use_id, qa_parent_qa_id)
  VALUES ('Euhm...', 2, '2016-08-30 18:59:00',
        SELECT use_id FROM user WHERE use_name = 'rudy',
        4);
INSERT INTO question_answer (qa_body, qa_score, qa_timestamp, qa_use_id, qa_parent_qa_id)
  VALUES ('Omdat de structuur en instellingen niet zo flexibel zijn en omdat het extensions-systeem nogal complex in elkaar zit. De tonnen XML die nodig zijn voor Maven kunnen we ook missen.', 1, '2016-08-30 19:45:00',
        SELECT use_id FROM user WHERE use_name = 'pedro',
        4);

INSERT INTO vote (vot_use_id, vot_qa_id, vot_is_up)
  VALUES (SELECT use_id FROM user WHERE use_name = 'lars', 1, TRUE);
INSERT INTO vote (vot_use_id, vot_qa_id, vot_is_up)
  VALUES (SELECT use_id FROM user WHERE use_name = 'lars', 10, TRUE);
INSERT INTO vote (vot_use_id, vot_qa_id, vot_is_up)
  VALUES (SELECT use_id FROM user WHERE use_name = 'lars', 4, FALSE);
