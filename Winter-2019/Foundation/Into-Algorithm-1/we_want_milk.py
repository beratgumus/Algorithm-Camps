# Problem: https://www.hackerrank.com/contests/inzva-02-algorithm-1-online-2018/challenges/we-want-milk/problem
# Author: Kadir Emre Oto (keoto)

N, M = map(int, raw_input().split())
A = [map(int, raw_input().split()) for i in xrange(N)]
A.sort()

ans = 0

for p, l in A:
    if M <= 0:
        break

    ans += p * min(l, M)
    M -= l

print ans
