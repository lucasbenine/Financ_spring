import Navbar from '../components/Navbar/index';
import styled from 'styled-components';
import img1 from '../img/1.jpg';
import img2 from '../img/2.jpg';
import img3 from '../img/3.jpg';
import Footer from '../components/Footer/index';

const Parallax = styled.div `
  width: 100%;
  height: 100%;

`;

function Home() {
  return (
    <>
      <Navbar />
      <Footer />
    </>
  );
}

export default Home;
