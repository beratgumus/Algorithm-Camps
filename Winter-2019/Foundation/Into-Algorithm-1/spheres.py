# Problem: https://www.hackerrank.com/challenges/spheres/problem
# Author: Kadir Emre Oto (keoto)

def f(t):
    n1 = [it + 0.5 * a1[i] * pow(t, 2) for i, it in enumerate(p1)]
    n2 = [it + 0.5 * a2[i] * pow(t, 2) for i, it in enumerate(p2)]

    dist = sum([pow(n1[i] - n2[i], 2) for i in xrange(len(n1))]) ** 0.5
    return dist
    
def ternary_search():
    left = 0
    right = 10**5
    eps = 1e-9

    while right - left > eps:
        mid1 = left + (right - left) / 3.
        mid2 = right - (right - left) / 3.

        if f(mid1) > f(mid2):
            left = mid1
        else:
            right = mid2 
    
    return f(left)


for t in xrange(int(raw_input())):
    R1, R2 = map(int, raw_input().split())
    p1 = map(int, raw_input().split())
    a1 = map(int, raw_input().split())

    p2 = map(int, raw_input().split())
    a2 = map(int, raw_input().split())

    closest = ternary_search()
    print 'YES' if closest <= R1 + R2 else 'NO'
