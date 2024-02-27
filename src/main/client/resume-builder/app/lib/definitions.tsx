export type Resume = {
  id: string;
  sentences: Sentence[];
};

export type Sentence = {
  id: string;
  text: string;
  sentenceType: SentenceType;
};

export enum SentenceType {
  INFO,
  TITLE,
  PARAGRAPH,
  BULLET_POINT,
}
