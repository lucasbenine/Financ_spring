import { render, screen, cleanup } from '@testing-library/react';
import "@testing-library/jest-dom/extend-expect";
import Footer from '../Footer/index';

test('deve renderizar o footer', () => {
    render(<Footer />);
    const footerElement = screen.getByTestId('footer-test1');
    expect(footerElement).toBeInTheDocument();
    expect(footerElement).toHaveTextContent('Todos os direitos reservados');
})