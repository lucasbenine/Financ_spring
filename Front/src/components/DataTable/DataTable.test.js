import { screen, render } from "@testing-library/react";
import "@testing-library/jest-dom/extend-expect";

import DataTable from './';

test("Deve conter uma tabela", () => {
    render(<DataTable />);

    const table = screen.getByTestId('table-test');

    expect(table).toBeInTheDocument();
})

test("Não deve renderizar o modal", () => {
    render(<DataTable />);

    const modal = screen.getByTestId('modalDetails');

    expect(modal).toBeInTheDocument();
})