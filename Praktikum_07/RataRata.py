from __future__ import print_function

# NIM       : 13518056
# Nama      : Michael Hans
# Tanggal   : Jumat, 22 Oktober 2021
# Topik     : Menghitung Rata-Rata

N = int(input())
score_map = {}

for i in range(N):
    text = input()
    temp_dict = text[1:len(text)-1].split(",")
    key = temp_dict[0][1:len(temp_dict[0])-1]
    value = int(temp_dict[1])
    score_map[key] = value

sum = 0
for key in score_map:
    sum += score_map[key]

mean = int(sum / len(score_map))
print(mean)

c = []
for key in score_map:
    if (score_map[key] < mean):
        c.append(key)

print(*c, sep = ",")