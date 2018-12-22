close all ;
clear all;
nums = load('result11.txt');
data = load('Num11.txt');
num_col = 1;
time_col = 2;
data = data(:,num_col);
data = setdiff(data, nums);
index = randperm(length(data),20);
data = data(index);
fid = fopen('check11.txt','w');
for i = 1:length(data)
    num_str= num2str(data(i));
    fprintf(fid,'%s\n',num_str);
end
fclose(fid);
