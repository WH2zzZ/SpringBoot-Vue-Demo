from public import common
import json
import random
def get_json_data_lines(source):
    messages = []
    lines = common.read_file(source)
    random.shuffle(lines)
    for line in lines:
        data = json.loads(line)
        kuangjia = data['kuangjia']
        if kuangjia == "junit4":
            if len(messages) == 20:
                break
            data['id'] = len(messages)
            del data['kuangjia']
            messages.append(json.dumps(data,ensure_ascii=False))
    
    common.write_to_file(r'single_unit.json', messages)


def get_project_data_lines(source):
    messages = []
    lines = common.read_file(source)
    random.shuffle(lines)
    for line in lines:
        data = json.loads(line)
        query = data['query']
        info = common.get_between_content(query, '''【被测代码】''', '''【要求】''')
        prompt1 = '''请用junit4和powermock框架对【被测代码】生成单元测试代码\n【被测代码】\n{}'''.format(info)
        prompt2 = '''【被测代码】\n{}\n请用junit4和powermock框架生成单元测试代码'''.format(info)
        prompt3 = '''对【被测代码】生成单元测试代码\n【被测代码】\n{}\n请用junit4框架'''.format(info)
        if len(messages) == 20:
            break
        data['id'] = len(messages)
        data['query'] = random.choice([prompt1, prompt2, prompt3])
        messages.append(json.dumps(data,ensure_ascii=False))

    common.write_to_file(r'project_unit.json', messages)

def unin_data(source1, source2):







    
        






    
def show(source):
    lines = common.read_file(source)
    for index, line in enumerate(lines):
        data = json.loads(line)
        query = data['input']
        qianwen = data['qianwen']
        xinghuo = data['xinghuo']
        print("=================={}=========================".format(index+1))
        print("=============qianwen=================")
        print(qianwen)
        print("=============xinghuo=================")
        print(xinghuo)

if __name__ == '__main__':
    # get_json_data_lines(r'E:\work\2024\SFT\11月\UT\i3026_j4j5_single_function_gpt4o_2.3k.json')

    get_project_data_lines(r'E:\work\2024\SFT\unit\v1\i3221_wanxinp2p-master.json')
    
    # show(r'single_unit_answer.json')

