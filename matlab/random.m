close all
clear all
num = randi(800000,[1 1000000]);
fid = fopen('test8.txt','w');
fprintf(fid,'%s\n',num2str(length(num)))
fprintf(fid,'%s',num2str(num(1)))
for i=2:length(num)
    fprintf(fid,' %s',num2str(num(i)));
end
fclose(fid);
