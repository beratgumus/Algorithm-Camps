results = [0] + [float("inf")]*100000
coins = [1, 2, 7, 10]

for coin in coins:
    for i in range(len(results) - coin - 1, -1, -1):
        results[i + coin] = min(results[i + coin], results[i] + 1)

print(results[int(input())])