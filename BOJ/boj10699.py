'''
boj10699. 오늘 날짜
'''
from datetime import datetime, timedelta
print(str(datetime.utcnow() + timedelta(hours=9))[:10])