def report(xs):
    numberResidents = 0
    numberApartments = 0

    for element in xs:
        if isinstance(element, int):
            numberApartments = numberApartments + 1
        else:
            numberResidents = numberResidents + 1
    
    averagePerApr = numberResidents / numberApartments
    
    peopleCounter = 0
    familyCountList = list()

    for element in xs:
        if isinstance(element, int) and element != xs[0]:
            familyCountList.append(peopleCounter)
            peopleCounter = 0
        elif isinstance(element, str):
            peopleCounter = peopleCounter + 1
    
    largestFamily = max(familyCountList)    
    result = [averagePerApr, largestFamily]

    return result
    

# Test 1
print("First Apartment Report")
residents = [100, "Jill Johnson", "Billy Ray Cyrus", 110, "Shweta Agarwal", 120, "Miguel Rosas", "Elena Rosas", "Mateo Rosas", 200, "Jason Chan", 210, "Rosalia Torres"]
print(residents)
print(report(residents))

# Test 2
print("Second Apartment Report")
residents2 = [324, "Arthas", "Uther", "Lich", "Kael", 100, "Grunt", "Ghoul", "Bear", 102, "Illidan", 670, "Archimonde", "Malganis", 1009, "Malfurion", "Maiev", "Tyrande", 309, "Thrall", "Rexxar"]
print(residents2)
print(report(residents2))


