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

bad_chars = ['[', ']', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0']
queue = [root]
leaves = []
node_decl = []
attribs = []
attrib_decl = []

while len(queue):
    node = queue.pop(0)
    path = tree.getpath(node)
    for char in bad_chars:
        path = path.replace(char, '')
    for child in node:
        child_path = tree.getpath(child)
        for char in bad_chars:
            child_path = child_path.replace(char, '')
        if len(child) == 0:
            leaves.append((node.tag, child.tag))
            node_decl.append('Node ' + node.tag.lower() + 'Node = root.selectSingleNode("' + path + '");\n')
        else:
            queue.append(child)
        if len(child.attrib) != 0:
            for key, value in child.attrib.items():
                attrib_decl.append('Node ' + child.tag.lower() + key.capitalize() + 'Node = root.selectSingleNode("' +
                                   child_path + '").getAttributes().getNamedItem("' + key + '");\n')
                attribs.append(args.prefix + '.set' + child.tag.lower() + key.capitalize() + '(' +
                               child.tag.lower() + key.capitalize() + 'Node.getNodeValue());\n')

node_decl = list(dict.fromkeys(node_decl))
for n in node_decl:
    output.write(n)
output.write('\n\n')

attrib_decl = list(dict.fromkeys(attrib_decl))
for n in attrib_decl:
    output.write(n)
output.write('\n\n')

attribs = list(dict.fromkeys(attribs))
for n in attribs:
    output.write(n)
output.write('\n\n')

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
