import API from "../api/API.tsx";
import {IPerson} from "../component/IPerson.tsx";
import {AxiosResponse} from "axios";

export const PersonService = {
  findAll: (): Promise<AxiosResponse<IPerson[]>> => {
    return API.get("person");
  },
  findById: (id: string) => {
    return API.get("person/" + id);
  },
  create: (data: any = {}) => {
    return API.post("person", data);
  },
  update: (id: string, data: any = {}) => {
    return API.put("person/" + id, data);
  },
  delete: (id: string) => {
    return API.delete("person/" + id);
  },
};