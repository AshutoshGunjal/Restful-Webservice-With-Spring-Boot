insert into user_details(id, birth_date,name)
values(1001, current_date(),'Ashu');

insert into user_details(id, birth_date,name)
values(1002, current_date(),'John');

insert into user_details(id, birth_date,name)
values(1003, current_date(),'Mike');

insert into post(id, description, user_id)
values(20001,'I want to learn Cloud', 1001);

insert into post(id, description, user_id)
values(20002,'I want to learn Data Science', 1001);

insert into post(id, description, user_id)
values(20003,'I want to learn Machine Learning', 1002);

insert into post(id, description, user_id)
values(20004,'I want to learn AI', 1002);