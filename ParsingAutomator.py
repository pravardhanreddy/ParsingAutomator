import argparse
from lxml import etree

parser = argparse.ArgumentParser()
parser.add_argument('-i', '--input', action='store', required=True,
                    help="Specifies the input file")
parser.add_argument('-o', '--output', action='store', required=True,
                    help='Specifies the output file')
parser.add_argument('-b', '--bean', action='store', required=True,
                    help='Specifies the class file')
args = parser.parse_args()

tree = etree.parse(args.input)
root = tree.getroot()
output = open(args.output, 'w')
bean = open(args.bean, 'w')

queue = [root]
leaves = []

while len(queue):
    node = queue.pop(0)
    for child in node:
        if len(child) == 0:
            leaves.append((node.tag, child.tag))
        else:
            queue.append(child)

output.close()
bean.close()
