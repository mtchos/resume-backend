import API from "./API.tsx";
import { PersonType } from "../component/PersonType.tsx";
import { AxiosResponse } from "axios";

export const PersonAPI = {
    findAll: (): Promise<AxiosResponse<PersonType[]>> => {
        return API.get("persons");
    },
    findById: (id: string): Promise<AxiosResponse<PersonType>> => {
        return API.get("persons/" + id);
    },
    create: (data: any = {}): Promise<AxiosResponse<PersonType>> => {
        return API.post("persons", data);
    },
    update: (id: string, person: PersonType): Promise<AxiosResponse<PersonType>> => {
        return API.put("persons/" + id, person);
    },
    delete: (id: string): Promise<AxiosResponse<void>> => {
        return API.delete("persons/" + id);
    },
};