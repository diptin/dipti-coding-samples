#!/usr/bin/python

def check_isomorphic(s1, s2) :
 d = dict()
 if len(s1) != len(s2) :
  return False
 for i in range(0, len(s1)) :
  if s1[i] in d :
    if d[s1[i]] != s2[i] :
     return False
  else :
   if s2[i] in d.values() :
    return False
   d[s1[i]] = s2[i]
 return True

s1 = raw_input("Enter first string : ")
s2 = raw_input("Enter second string : ")

is_isomorphic = check_isomorphic(s1, s2)
if(is_isomorphic) :
 print "The srings are isomorphic"
else :
 print "The strings are NOT isomorphic"
