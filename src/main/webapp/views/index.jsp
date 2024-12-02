<jsp:include page="includes/header.jsp" />  

<jsp:include page="includes/homeNav.jsp"/>

<head>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&family=Roboto+Slab:wght@700&family=Lato:wght@400;700&family=Merriweather:wght@400;700&display=swap" rel="stylesheet">
</head>
<style>
  .carousel-item {
  height: 100vh;
  min-height: 300px;
  background: no-repeat center center scroll;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  
}
 body {
    font-family: 'Roboto', sans-serif;
    background-color: #212529;
    color: white;
    font-family: 'Arial', sans-serif;
  }
  h1, h2, h3, h4, h5, h6 {
    font-family: 'Roboto Slab', serif;
  }
  p {
    font-family: 'Lato', sans-serif;
  }
  .carousel-caption h3 {
    font-family: 'Roboto Slab', serif;
  }

  .carousel-caption p {
    font-family: 'Lato', sans-serif;
  }
  .featurette-heading {
    font-family: 'Roboto Slab', serif;
  }
    footer {
    font-family: 'Merriweather', serif;
  }

  footer p, .footer_title {
    font-family: 'Merriweather', serif;
  }
  
 .featurette-divider{
  background-color:white;
  
  }

</style>
<header style="margin-top: -40px;">
  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
      
      <div class="carousel-item active" style="background-image: url('https://cdn.pixabay.com/photo/2016/11/22/21/46/arches-1850730_640.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>EventVista</h3>
          <p class="text-white">The Perfect Planner</p>
        </div>
      </div>
      
      <div class="carousel-item" style="background-image: url('../assets/images/hotels/2.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Main Hall</h3>
          <p class="text-white"> Main Hall, making it suitable for a variety of events. </p>
        </div>
      </div>
     
      <div class="carousel-item" style="background-image: url('https://cdn.pixabay.com/photo/2017/08/31/15/21/wedding-reception-2701035_640.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Reception</h3>
          <p class="text-white"> elegance, customization, and seamless service your reception offerings provide for various events.</p>
        </div>
      </div>
       
       <div class="carousel-item" style="background-image: url('https://cdn.pixabay.com/photo/2018/11/16/17/48/chips-3819922_640.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Catering Bufe</h3>
          <p class="text-white" > wide range of options, quality, and customization of the catering buffet service for any type of event</p>
        </div>
      </div>
      
       <div class="carousel-item" style="background-image: url('https://cdn.pixabay.com/photo/2016/12/28/20/30/wedding-1937022_640.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Dulex And SuperDulex</h3>
          <p class="text-white">Both venues provide customizable options to meet your specific requirements, ensuring every detail aligns with your vision.</p>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</header>

<section id="service-section" class="mt-5 mb-5 pr-3">
		 <div class="container marketing text-center">

        <!-- Three columns of text below the carousel -->
        <div class="row">
          <div class="col-lg-4 ">
            <img class="rounded-circle" src="https://2.bp.blogspot.com/-uDJeJFTy6e0/Wnqn8j3OOoI/AAAAAAAABTQ/vxh5_Uft6g0BPpjdYkOzMx4NTleHE55PQCLcBGAs/s1600/MS%2BMarriage-marriage-hall-chennai.jpg" alt="Generic placeholder image" width="240" height="240">
            <h2>HALLS</h2>
            <p>With sample space, exquisite decor, and exceptional service, our halls provide the ideal setting to make your event unforgettable. Let us help you create memories that will last a lifetime in one of our stunning event spaces</p>
          
          </div>
          <div class="col-lg-4">
            <img class="rounded-circle" src="https://images.pexels.com/photos/2291367/pexels-photo-2291367.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="Generic placeholder image" width="240" height="240">
            <h2>CATERING</h2>
            <p>We offer a wide range of options, including customizable buffet spreads, plated meals, and themed catering to match the style of your event. Using only the freshest ingredients and the finest flavors, we ensure that each dish not only looks beautiful but also tastes amazing.</p>
            
          </div>
          <div class="col-lg-4">
            <img class="rounded-circle" src="https://assets.website-files.com/62a9b4f36a23c435c9b9f3cc/63bfbaae01df7e37a0686313_entrepreneur-carrying-3-boxes.jpeg" alt="Generic placeholder image" width="240" height="240">
            <h2>VENDORS</h2>
            <p>Our trusted network of vendors ensures that every aspect of your event is flawless. From florists to photographers, entertainers to decorators, we work with the best in the industry to bring your vision to life. Whether you're hosting a lavish wedding, a corporate gala, or a small gathering.</p>
           
          </div>
         </div>
</section>


<hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
            <div class="mt-1 text-center">
              <h2 class="featurette-heading mt-2">HALLS<p class="text-muted mt-2">It'll blow your mind.</p></h2>
            </div>
            <div class="mt-3">
              <p class="lead">Our event halls are the perfect venue for a variety of occasions, from grand weddings to intimate gatherings. Designed with elegance and comfort in mind, each hall is equipped with state-of-the-art facilities to ensure a seamless event experience. Whether you're hosting a corporate meeting, a birthday party, or a wedding reception, our versatile halls can be customized to fit the theme and atmosphere you envision.</p>
            </div>
          </div>
          <div class="col-md-5">
            <img class="featurette-image img-fluid mx-auto"  src="https://cdn.pixabay.com/photo/2016/09/12/23/21/chairs-1666070_640.jpg" alt="Generic placeholder image">
          </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7 order-md-2">
            <div class="mt-1 text-center">
              <h2 class="featurette-heading mt-2">CATERING <p class="text-muted mt-2">The best memories are made around the dinner table</p></h2>
            </div>
              <div class="mt-3">
                <p class="lead">Our catering services are designed to elevate your event with mouthwatering dishes that cater to all tastes and preferences. Whether you're planning an extravagant wedding banquet, a corporate lunch, or an intimate family gathering. our team of professional chefs is dedicated to crafting a menu that delights your guests.</p>
              </div>
           </div>
          <div class="col-md-5 order-md-1">
            <img class="featurette-image img-fluid mx-auto" src="https://arzfinefoods.com/wp-content/uploads/2018/11/Catering_Promo.jpg" alt="Generic placeholder image">
          </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
            <div class="mt-1 text-center">
              <h2 class="featurette-heading mt-2">VENDORS <p class="text-muted mt-2">An artist is not paid for his Labor but for his vision.</p></h2>
            </div>
            <div class="mt-3">
              <p class="lead">Each vendor is carefully selected for their reliability, creativity, and professionalism. You can choose from a variety of services to make your event truly unique from custom floral arrangements to expert DJs and everything in between.</p>
            </div>
          </div>
          <div class="col-md-5">
            <img class="featurette-image img-fluid mx-auto" src="https://cdn.pixabay.com/photo/2016/11/23/17/56/wedding-1854074_640.jpg" alt="Generic placeholder image">
          </div>
        </div>
    



<!-- footer-section -->
        <section class="footer-section">
            <footer class="footer">
                <p class="footer_title">Contact us</p>
                    <div class="footer_social">
                        <a href="#" class="footer_icon"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="footer_icon"><i class="fab fa-instagram"></i></a>
                        <a href="#" class="footer_icon"><i class="fab fa-twitter"></i></a>
                    </div>
                <p>&#169; 2024 Event Management System</p>
            </footer>
        </section>
<jsp:include page="includes/footer.jsp" />  