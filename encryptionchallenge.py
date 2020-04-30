import math
class encryption:
    while True:
        currentStr = str(input("Please Enter A Sentence to Encrypt: ").lower())
        strList = [i for i in currentStr if i.isalpha()]
        countLength = len(strList)

        if 1 < countLength and countLength < 81:
            break
        else:
            print("Please enter a sentence between 1 - 81 characters.")
            continue

    def encryptSentence(self):
        encrpytedString = ""
        currentRow = 0
        currentCol = 0
        row = math.floor(self._getSQRT(self.countLength))
        col = math.ceil(self._getSQRT(self.countLength))

        if ((row * col) <= self.countLength):
            row +=1

        strTable = self._getMatrix(row,col)
        while True:
            if currentCol >= col:
                break
            elif currentRow == row:
                currentRow = 0
                currentCol +=1
                print(end=" ")
            else:
                encrpytedString = encrpytedString.join(strTable[currentRow][currentCol])
                currentRow +=1
                print(encrpytedString,end="")
        return ""

    def _getSQRT(self,strCount):
        return math.sqrt(strCount)

    def _getMatrix(self,row,col):
        matrix = [[' ' for x in range(col)] for y in range(row)]
        currentLetter = 0

        for i in range(row):
            for j in range(col):
                if currentLetter != self.countLength:
                    matrix[i][j] = self.strList[currentLetter]
                    currentLetter +=1
                else:
                    break
        return matrix


# Driver code to test the program
#If we input the following sentence we should get the following result.
#Sentence : if man was meant to stay on the ground god would have given us roots
#Result : imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau
obj = encryption()
obj.encryptSentence()
