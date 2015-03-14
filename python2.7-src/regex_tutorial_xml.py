#!/usr/bin/python

# Python regex example 

import re

objfile = open("NYTWorld.xhtml","r",1)
print objfile.name

line = objfile.read()
matchtitle = re.findall(r'(<title>)(.*?)(</title>)', line, re.M|re.I)

newsDateMap = dict();
count = 0
for mat in matchtitle:
   newsDateMap[count] = mat[1]
   count = count + 1

matchdate = re.findall(r'(<pubdate>)(.*?)(</pubDate>)', line, re.M | re.I)

count = 0
for mat in matchdate:
   newsDateMap[count] = newsDateMap[count] + mat[1]
   count = count + 1

print newsDateMap

objfile.close()
