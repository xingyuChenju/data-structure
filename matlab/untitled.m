clear all
close all
a=xlsread('第一次竞赛成绩.xlsx');
sum0 = a(:,3) == 0;
aadada = sum(sum0);
index = a(:,3)<=2;
a(index(1:(50-aadada)),3) =a(index(1:(50-aadada)),3)+1;
a(sum0,3) = a(sum0,3)+1;
bbb = max(a(:,3));
index1 = a(:,3)==bbb;
sub_data = a(~index1,1);
index2 = randperm(length(sub_data),50);
studentNum = sub_data(index2);
for i = 1:length(a)
    if ~isempty(find(studentNum==a(i,1)))
        a(i,3) = a(i,3)+1;
    end
end

fid = fopen('result.txt','w');
for i=1:50
   mm = num2str(studentNum(i));
    %a = char(a);
    fprintf(fid,'%s\n',mm);
end
fclose(fid);
fid2 = fopen('Num.txt','w');
for i=1:length(a)
  kk = num2str(a(i,1));
   nn = num2str(a(i,3));
   ww = [kk ' ' nn];
    %a = char(a);
    fprintf(fid2,'%s\n',ww);
end
fclose(fid2);
