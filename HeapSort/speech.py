import os
from gtts import gTTS 
import time
import os, sys, inspect
from pathlib import Path
parentPath = Path().resolve().parent
from tempfile import TemporaryFile

sys.path.insert(0, '{}/'.format(parentPath))

def play(answer, lang):
    if lang == 'en':
        print(answer)
        tts = gTTS(text=answer, lang=lang)
    if lang == 'ru':
       tts = gTTS(text=answer, lang=lang)
    if lang == 'cn':
        tts = gTTS(text=answer, lang='zh-cn')
    print('play this answer : {}'.format(answer))
    # tts.save('answer.mp3')
    os.system('mpg321 {}/answer.mp3'.format(os.getcwd()))	
    # os.system('rm answer.mp3')


def main(): 
    play('Здравствуйте, вас приветствует программа визуализации алгоритма Пирамидальная сортировка. Что бы начать работу нажмите старт. Что бы увидеть следующий шаг нажмите нэкст стэп. Что бы вернуться к предыдущему шагу нажмите превиус стэп. Также вы можете выбрать интересующий вас тестовый фаил. ','ru')


if __name__ == '__main__':
    main()


# import time
# import os
# data = "Текст: Здравствуйте, вас приветствует программа визуализации алгоритма Пирамидальная сортировка. Что бы начать работу нажмите старт. Что бы увидеть следующий шаг нажмите нэкст стэп. Что бы вернуться к предыдущему шагу нажмите превиус стэп. Также вы можете выбрать интересующий вас тестовый фаил. "
# # while True:
# #     try:
# #         with open('./sat.dat', 'r') as file:
# #             data  = file.read().splitlines();
# #             if data
# #             print("python: "data)
# #             tts_Engin.play('{}'.format(data),'ru')
# #             file.close()
# time.sleep(1)

# os.system(tts_Engin.play('{}'.format(data),'ru'))


# # jar cvf HeapSort.jar HeapSort/src/etu/model/BuildGraph.class Bar.class