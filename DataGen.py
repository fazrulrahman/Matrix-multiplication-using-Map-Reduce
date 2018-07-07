import random


Mrow = 100

Mcolumn = 100
Nrow = 100

Ncolumn = 100

def matgen(A,row,column):
	file = open("Matrix.txt",'a')
	value = 0

	for i in range(1,column):
		for j in range(1,row):
			zerofreq = random.randint(0,2)	# How sparse the matrix is incresing count increases more 0's hence more sparse
			if zerofreq == 2:
				value = random.randint(1,25)	# Matrices Values between 1 and 25
				file.write(A+","+str(i)+","+str(j)+","+str(value)+"\n")
			value = 0
	file.close()

matgen("M",Mrow,Mcolumn)
matgen("N",Nrow,Ncolumn)
