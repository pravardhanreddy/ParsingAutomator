import argparse
from lxml import etree


parser = argparse.ArgumentParser()
parser.add_argument('-i', '--input', action='store', required=True,
                    help="Specifies the input file")
parser.add_argument('-o', '--output', action='store', required=True,
                    help='Specifies the output file')
parser.add_argument('-b', '--bean', action='store', required=True,
                    help='Specifies the class file')
parser.add_argument('-p', '--prefix', action='store', required=True,
                    help='Specifies the prefix')
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

count_child = [y for (x, y) in leaves]
leaves = list(dict.fromkeys(leaves))

for p, c in leaves:
    if count_child.count(c) == 1:
        output.write(args.prefix + '.set' + p.capitalize() + c.capitalize() +
                     '(nullStrToSpc(AascXmlParser.getValue((Element) ' + p.lower() +
                     'Node, "' + c + '")));\n')
    else:
        output.write(args.prefix + '.set' + c.capitalize() +
                     '(nullStrToSpc(AascXmlParser.getValue((Element) ' + p.lower() +
                     'Node, "' + c + '")));\n')

output.close()
bean.close()
