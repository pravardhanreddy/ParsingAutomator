# ParsingAutomator
Create the class and bean file automatically

# Requirements
* Install Python3+ (preferably anaconda)
* Open anaconda prompt and install package lmml using the following command
```
conda install lxml
```

# Usage
* After downloading the ParsingAutomator.py file, in anaconda prompt, navigate to the folder where the file is downloaded
* Have the input xml file in the same directory
* Run the following command in the prompt

```
python ParsingAutomator.py -i manifest.xml -o ouput.java -b myclass.java -p aascTNTManifestInfo
```
* You can find information about the arguments using the -h argument as shown below
```
python ParsingAutomator.py -h
```
