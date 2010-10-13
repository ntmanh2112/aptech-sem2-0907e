def x2(x):
	return x * 2;

def xx(x):
	return x * x;

def simple_python():
	# True, False, None
	# don't assume True or False.
	
	a = 0
	b = 1
	c = 2.0
	x = y = z = 3
	
	# + - * / // %
	# mixing integer and float results in float.
	d = a + b + c
	# float(some_number), rint(some_number), str(some_number)
	
	# string concatenation +
	# non-string must be converted to string str() before concatenation.
	# string should use double quote and triple double quote.
	
	# List
	fruits = ["orange", 333, "apple", "pear"]
	# fruits[0] = orange
	# fruits[1] = 333
	# fruits[-1] = pear
	# fruits[-2] = apple
	# len(fruits) = 4
	
	# Dictionary
	abc = {"a":"apple", "b":"bob", "c":"cat"}
	# abc["a"] = apple
	# abc["c"] = cat
	# abc.keys() = [a, b, c]
	
	# if (condition1):
	#	do 1st things
	# elif (condition2):
	#	do 2nd things
	# else:
	#	do other things
	
	# c = 0 if (s == "xyz") else 5
	
	# for object in object_array:
	#	do something
	#	break
	
	# for i in range(20):
	#	do something
	#	break
	
	# for k, v in abc.iteritems()
	#	do something
	#	break
	
	# def function_name(input1, input2, input3 = default3):
	#	do something
	#	return some answer
	
	# string builder
	# sb = []
	# sb.append("abc")
	# sb.append("xyz")
	# s = "".join(sb)
	
	
	return """
Hi,<br /><br />
My name is Lala""" + "www" + """ Land.<br /><br />
I am a zoo.
"""
