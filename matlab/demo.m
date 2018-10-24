load('num.mat');
index = randperm(length(num),50);
result = num(index);
aaa =[];
for i = 1:length(result)
    m = result(i);
    aaa =[aaa;num2str(m{1})];
end
for i =1:5
    p = aaa((1+(i-1)*10):i*10);
    save(['pqfile' num2str(i) '.txt'],'p','-ascii')
end

