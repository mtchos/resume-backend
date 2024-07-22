import { Select } from "@mantine/core";

export default function SelectUser() {
  return (

      <Select
          label="Selecione um usuário"
          placeholder="Usuário"
          data={["a", "b"]}
          searchable
      />
  );
}