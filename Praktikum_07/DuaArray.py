from __future__ import print_function

# NIM       : 13518056
# Nama      : Michael Hans
# Tanggal   : Jumat, 22 Oktober 2021
# Topik     : Input Dua String sebagai Array

a = input()
b = input()
c = []

arr_a = a.split(",")
arr_b = b.split(",")

for element1 in arr_a:
    sum = 0
    for element2 in arr_b:
        sum += int(element1) * int(element2)
    c.append(sum)

print(*c, sep = ",")