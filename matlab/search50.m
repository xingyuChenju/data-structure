%% ÿ�γ�����д������ٵ��ˣ��ٴ�ʣ�µķ���ߴε�����������飬��������ٴ���ߴε�����������顣
clear all;
close all;
% data �������ѧ��
% data _rec��¼ԭʼ��������´���
data = load('Num07.txt')
data_rec = data;
num_col = 1; %��ʾѧ�Ŷ�Ӧ���� 
time_col = 2; %��ʾ������Ӧ����
% ��ѡ���������ٵ���,Ȼ��ɾ��
time_set =  unique(data(:,time_col));
index = data(:,time_col) == min(time_set);
nums = data(index,num_col);
data(index,:) =[]; 
% ������������Ӵ�����������������ѡ
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
% �����д���ļ�
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

