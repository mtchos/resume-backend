import { v4 as uuid } from "uuid";

export type PersonType = {
    id: typeof uuid;
    resumes: string[];
    username: string;
    email: string;
    password: string;
};