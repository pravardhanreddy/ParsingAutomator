import argparse
from lxml import etree

parser = argparse.ArgumentParser()
parser.add_argument('-i', '--input', action='store', required=True,
                    help="Specifies the input file")
parser.add_argument('-o', '--output', action='store', required=True,
                    help='Specifies the output file')
parser.add_argument('-c', '--class', action='store', required=True,
                    help='Specifies the class file')
args = parser.parse_args()
