"""
4주차. 직업군 추천하기
"""


def solution(table, languages, preferences):
    industries_dict = dict()
    for row in table:
        parsed_row = row.split(' ')
        industry = parsed_row[0]
        lang_dict = industries_dict.get(industry, dict())

        for i in range(1, 6):
            lang_dict[parsed_row[i]] = 6 - i

        industries_dict[industry] = lang_dict

    industries_preference_dict = {k: 0 for k in industries_dict.keys()}
    for i in range(len(languages)):
        for industry in industries_preference_dict.keys():
            total = preferences[i] * \
                industries_dict[industry].get(languages[i], 0)
            industries_preference_dict[industry] += total

    max_industry = ''
    max_preference = -1
    for industry, preference in industries_preference_dict.items():
        if preference > max_preference:
            max_preference = preference
            max_industry = industry
        elif preference == max_preference:
            if industry < max_industry:
                max_industry = industry

    return max_industry


table1 = ["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
          "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"]
languages1 = ["JAVA", "JAVASCRIPT"]
preference1 = [7, 5]
result1 = "PORTAL"

assert solution(table1, languages1, preference1) == result1
