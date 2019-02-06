cache = {}

def fibonacci(n):

    if n < 2:
        return 1

    if n in cache:
        return cache[n]
    
    cache[n] = fibonacci(n - 1) + fibonacci(n - 2)
    return cache[n]

print(fibonacci(int(input("Which term of fibonacci do you want to know: "))))