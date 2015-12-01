#!/usr/bin/python

def pascal_triangle() : 
 spaces = 20
 row = []
 row.append(1)
 print (' '*spaces), row
 spaces-=2
 for i in range (1,5):
	prev_row = row
	row = []
  	row.append(1)
  	c = 1
  	for j in range (1,len(prev_row)) :
		row.append(prev_row[c-1] + prev_row[c])
		c+=1
  	row.append(1)
  	print (' '*spaces), row
  	spaces-=2


def simple_triangle() :
 spaces = 20
 for i in range (1,6) :
 	row = []
 	for j in range (1,i+1) :
		row.append(j)
  	print (' '*spaces), row 
  	spaces-=2


def pattern_name(num) :
 if num==1 :
  return "Pascal triangle"
 if num==2 :
  return "Simple triangle"

print "Patterns : "
print "1. Pascal's triangle\n2. Simple triangle"
inp = input("Select one pattern : ")
print "\nSelected pattern is '" + pattern_name(inp) + "'"

def select_pattern(n) :
 return {
  1: pascal_triangle,
  2: simple_triangle,
 }[n]()

select_pattern(inp)

