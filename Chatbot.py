import random
import string
import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity
import nltk
from nltk.stem import WordNetLemmatizer

nltk.download('punkt', quiet=True)  # first-time use only
nltk.download('wordnet', quiet=True)  # first-time use only

# Reading in the corpus from CSV without header
responses_df = pd.read_csv("./scholarships.csv", encoding='utf8', header=None)

# Combine column A and B to create a list of sentences, handling NaN values
raw_responses = (responses_df[0].fillna('') + ' ' + responses_df[1].fillna('')).str.lower().tolist()

# Extract links from column C
response_links = responses_df[2].fillna('').tolist()

# Tokenization
sent_tokens = nltk.sent_tokenize(" ".join(raw_responses))  # converts to a list of sentences

# Preprocessing
lemmer = WordNetLemmatizer()


def LemTokens(tokens):
    return [lemmer.lemmatize(token) for token in tokens]


remove_punct_dict = dict((ord(punct), None) for punct in string.punctuation)


def LemNormalize(text):
    return LemTokens(nltk.word_tokenize(text.lower().translate(remove_punct_dict)))


# Generating response with links only
def response(user_response):
    robo_response = ''
    sent_tokens.append(user_response)
    TfidfVec = TfidfVectorizer(tokenizer=LemNormalize, token_pattern=None)
    tfidf = TfidfVec.fit_transform(sent_tokens)
    vals = cosine_similarity(tfidf[-1], tfidf)
    idx = vals.argsort()[0][-2]
    flat = vals.flatten()
    flat.sort()
    req_tfidf = flat[-2]
    if req_tfidf == 0:
        robo_response = robo_response + "I am sorry! I don't understand you"
        return robo_response
    else:
        # Use the index to get the corresponding link from the response_links list
        robo_response = robo_response + response_links[idx]
        return robo_response


flag = True
print("Enter Your Query. If you want to exit, type Bye!")

while flag:
    user_response = input().lower()

    if user_response != 'bye':
        if user_response in ['thanks', 'thank you']:
            flag = False
            print(" You're welcome!")
        else:
            robo_response = response(user_response)
            print( end="")
            print(robo_response)
            sent_tokens.remove(user_response)
    else:
        flag = False