%% 每次抽查所有次数最少的人，再从剩下的非最高次的人里面随机抽，如果不够再从最高次的人里面随机抽。
clear all;
close all;
% data 操作随机学号
% data _rec记录原始结果最后跟新次数
data = load('Num07.txt')
data_rec = data;
num_col = 1; %表示学号对应的列 
time_col = 2; %表示次数对应的列
% 先选出次数最少的人,然后删除
time_set =  unique(data(:,time_col));
index = data(:,time_col) == min(time_set);
nums = data(index,num_col);
data(index,:) =[]; 
% 如果人数不够从次数不是最多的人里面选
if length(nums)<50
    len = 50 - length(nums);
    index = data(:,time_col) == max(time_set);
    if sum(~index)<len
        nums = [nums;data(~index,num_col)]
        data = data(index,num_col);
        len = 50 - length(nums);
        index = randperm(sum(index),len);
        nums = [nums;data(index)]
    else 
        data =data(~index,num_col);
        index = randperm(length(data),len);
        nums = [nums;data(index)];
    end
end
% 抽查结果写到文件
fid = fopen('resultxx.txt','w');
for i=1:50
    num_str= num2str(nums(i));
    fprintf(fid,'%s\n',num_str);
end
fclose(fid);
% 
fid = fopen('Numxx.txt','w');
for i = 1:length(data_rec)
    
    if find(nums==data_rec(i,num_col))
        data_rec(i,time_col) = data_rec(i,time_col)+1;
    end
    num_str= num2str(data_rec(i,num_col));
    time_str= num2str(data_rec(i,time_col));
     fprintf(fid,'%s\n', [num_str ' ' time_str]);
end
fclose(fid);

