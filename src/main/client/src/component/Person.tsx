import { useEffect, useState } from "react";
import { PersonAPI } from "../api/PersonAPI.tsx";
import { PersonType } from "./PersonType.tsx";

export default function Person() {
    const [ person, setPerson ] = useState<PersonType>();

    const findAll = () => {
        try {
            const response: any = PersonAPI.findAll();
            setPerson(response[0])
        } catch (error: any) {
            console.error(error)
        }
    };

    useEffect(() => findAll(), []);

    return (
        <>
            <div>id: {person?.id.toString()}</div>
            <div>email: {person?.email?.toString()}</div>
            <div>username: {person?.username?.toString()}</div>
            <div>password: {person?.password?.toString()}</div>
            {person?.resumes?.map((index, resume) => {
                return (
                    <div>resume {index + 1}: {resume.toString()}</div>
                );
            })}
        </>
    );
}