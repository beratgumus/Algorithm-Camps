fibonacci = [1, 1]

n = int(input("Which term of fibonacci do you want to know: "))

for _ in range(n - 1):
    fibonacci.append(fibonacci[-1] + fibonacci[-2])

print(fibonacci[-1])