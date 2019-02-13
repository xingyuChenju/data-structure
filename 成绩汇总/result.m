close all
clear all

path ='.\data\';
path2 = '.\game\';
result_name = 'result.xls';
grade_col = 3;
% m = cellstr(raw(2:end,:));
files = dir(path);
grades= {};

for i = 3:length(files)
    filename = files(i).name;
    [~,~,raw] = xlsread([path filename]);
    if isempty(grades)
        grades = raw;
         for i = 2:length(grades)
            grades{i,grade_col}= grades{i,grade_col};
        end
    else
        for i = 2:length(grades)
            grades{i,grade_col}= grades{i,grade_col}+ raw{i,grade_col};
        end
    end
end

files = dir(path2);
for i = 3:length(files)
    filename = files(i).name;
    [~,~,raw] = xlsread([path2 filename]);
    for i = 2:length(grades)
        grades{i,grade_col}= grades{i,grade_col}+raw{i,grade_col}/2;
    end
end

for i = 2:length(grades)
    grades{i,grade_col}= round(grades{i,grade_col}/12);
    if grades{i,grade_col} >100
        grades{i,grade_col} = 100;
    end
end
xlswrite(result_name,grades)
