import {v4 as uuid} from "uuid";

export type IPerson = {
    id: typeof uuid;
    resumes: string[];
    username: string;
    email: string;
    password: string;
};