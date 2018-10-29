len = 500;
p = randi(100,[1 len]);
fid = fopen('test.in','A');
fprintf(fid,'%d',p);
fclose(fid);