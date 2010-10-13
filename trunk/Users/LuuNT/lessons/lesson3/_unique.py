def rint(in_number):
	x = float(in_number)
	y = long(x)
	z = x - y
	if (z < 0.5): return y
	else: return y + 1
