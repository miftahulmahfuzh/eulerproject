def prime_generator(n):
    sieve = [True] * n
    for i in xrange(3,int(n**0.5)+1,2):
        if sieve[i]:
            sieve[i*i::i*2] = [False] * ((n-i*i-1)/(i*2)+1)
    return [i for i in xrange(3,n,2) if sieve[i]]

def cycle_val(n):
    remainders = {}
    num = 1
    for i in xrange(1,n):
        remainder = num%n
        if remainder == 0: return 0
        if remainder in remainders:
            return len(remainders) - remainders[remainder] + 1
        remainders[remainder] = i
        num = 10 * remainder
    return len(remainders)

def reciprocals(n):
    primes = prime_generator(n)
    nums = [0] * (n+1)
    for prime in primes:
        x = prime
        while x <= n:
            nums[x] = cycle_val(x)
            x *= prime
    temp = 0
    idx = 1
    for i in xrange(2,n):
        count = nums[i]
        nums[i] = idx
        if count > temp:
            temp = count
            idx = i
    return nums

list_rcp = reciprocals(10000)
t = int(raw_input())
for i in xrange(t): 
    print list_rcp[int(raw_input())]
