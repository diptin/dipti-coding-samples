#!/usr/bin/python

import sys

def fib(n):
 a,b = 0,1
 yield a
 if n>0 :
  yield b
  for i in range(2,n+1):
   a,b = b, a+b
   yield b

num = int(sys.argv[1])
gen = fib(num)
for i in gen:
 print i
