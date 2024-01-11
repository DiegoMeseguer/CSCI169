% Test class course

% test1 = course;
% test1.Level = "Red";

w1 = [42 123 124 163 168 666];
c = course("Family Fun", "Green", w1);
% c(5) = course("Kirbo", "Green", 100:104);
d = course("Nemo", "Yellow", [2;4;545]);

idvec = idstick(12345:12350);
% disp(idvec);

% disp(c);
% disp(d);
% z = course;
% disp(z);
% Test class idstick

% buba = idstick;
% buba.Participant = "Violetta";
% buba.Course.Waypoints = 10:15;
% buba.Status = "mente";
% signal(buba, true);
% 
% idout = idstick;
% idout = register(idout, "Erik", c);
% 
% idout2 = idstick(123455);
% 
% a = zeros(1,4);
% b = NaT(1,4);
% d = size(c.Waypoints);
% 
% foo = course("Bowser Castle", "Red", [2:10]);
% bar = idstick("555555");
% bar = register(bar, "Miguel", foo);

% id = idstick(123456);
% disp(id);
% 
% 
% id = register(id, "Pedro", c);
% disp(id);
% 
% 
% ed = idstick;
% disp(idstick);

megastick = idstick(1:5);
nombres = ["a", "b", "c", "d", "e"];
c(5) = course("Mt Diablo", "Red", 666:699);

megastick = register(megastick, nombres, c);

disp(megastick(5).Course);

zeta = course;

zeta = megastick(5).Course;







