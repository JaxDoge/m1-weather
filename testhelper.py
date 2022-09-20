c1 = -8.78469475556
c2 = 1.61139411
c3 = 2.33854883889
c4 = -0.14611605
c5 = -0.012308094
c6 = -0.0164248277778
c7 = 0.002211732
c8 = 0.00072546
c9 = -0.000003582
temp = 13
relative = 85
windSpeed = 7

def pow(num, order):
    return num**order

hi = c1 + c2 * temp + c3 * relative + c4 * relative * temp +\
c5 * pow(temp, 2) + c6 * pow(relative, 2) +\
c7 * pow(temp, 2) * relative + c8 * temp * pow(relative, 2) +\
c9 * pow(relative, 2) * pow(temp, 2)

wc = 35.74 + .6215 * temp - 35.75 * pow(windSpeed, .16) + .4275 * temp * pow(windSpeed, .16)

if __name__ == "__main__":
    print(hi)
    print(wc)
    print(3**3)