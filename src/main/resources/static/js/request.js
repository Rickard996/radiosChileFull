
//alert('making a request to API!')

//adding a change from branch master, to be added to branch main later!


/* Implementation of the presentation of the audio player */
import lottieWeb from 'https://cdn.skypack.dev/lottie-web';

/* Implementation of the presentation of the audio player 
At this point I have a nice card with an image. now I need to add the buttons
to control the radio

*/

//first read the radios from the server and create the needed cards
//lets use fectch api

const aplicattion = document.querySelector('body')
//select the body element. inside this im going to add the new elements

//select the div of class encabezado
const encabezado = document.querySelector('.encabezado')

//we dont need ; in javascript so far
//url of the api rest-type
//url for production
const url = 'https://ricardoradioschile.up.railway.app/api/radios'


fetch(url)
        .then(response=>{
            if(response.status==202){
                console.log('retrieving data!')

                //create a p with a message to the user
                const p = document.createElement('p')
                p.innerHTML = 'Hola, las siguientes radios fueron cargadas exitosamente!!'
                encabezado.appendChild(p)

                return response.json()   //return the json to be used as promise en the next then
                                .then(data=>{    //perform the operation with the data
                                    
                                    data.forEach(radio => {   //each radio is an element. for each radio perform this operation
                                        const parentDiv = document.createElement('div')
                                        parentDiv.setAttribute('class', 'card justify-content-center')  //the class
                                        parentDiv.setAttribute('align','center')
                                        //image of radio
                                        const imageRadio = document.createElement('img')
                                        imageRadio.setAttribute('class', 'card-img-top')
                                        imageRadio.setAttribute('src', './img/'+radio.image)
                                        imageRadio.setAttribute('alt', 'Card image cap')
                                        //h5
                                        const title = document.createElement('h5')
                                        title.setAttribute('class', 'card-title')
                                        title.innerHTML = `${radio.name}`
                                        //second div. will be a container for other content
                                        const secondDiv = document.createElement('div')
                                        secondDiv.setAttribute('class', 'container-new')
                                        //parentDiv to application, then the last 3 to parentDiv
                                        aplicattion.appendChild(parentDiv)
                                        parentDiv.appendChild(imageRadio)
                                        parentDiv.appendChild(title)
                                        parentDiv.appendChild(secondDiv)
                                        //other elements that go inside secondDiv

                                        //other div
                                        const thirdDiv = document.createElement('div')
                                        thirdDiv.setAttribute('class', 'audio-player-container')
                                        thirdDiv.setAttribute('align', 'center')
                                        secondDiv.appendChild(thirdDiv)

                                        //inside the thirdDiv
                                        const audioPlay = document.createElement('audio')
                                        audioPlay.setAttribute('src', radio.icecastSource)
                                        audioPlay.setAttribute('preload', 'metadata')

                                        const buttonPlay = document.createElement('button')
                                        buttonPlay.setAttribute('class', 'play-icon')

                                        const finalDiv = document.createElement('div')
                                        thirdDiv.appendChild(audioPlay)
                                        thirdDiv.appendChild(buttonPlay)
                                        thirdDiv.appendChild(finalDiv)
                                        //within the last div
                                        const outputVolume = document.createElement('output')
                                        outputVolume.setAttribute('class', 'volume-output')
                                        outputVolume.innerHTML = '100'
                                        const seekSlider = document.createElement('input')
                                        seekSlider.setAttribute('type', 'hidden')
                                        seekSlider.setAttribute('class', 'seek-slider')
                                        seekSlider.setAttribute('max', '100')
                                        seekSlider.setAttribute('value', '0')

                                        const volumeSlider = document.createElement('input')
                                        volumeSlider.setAttribute('type', 'range')
                                        volumeSlider.setAttribute('class', 'volume-slider')
                                        volumeSlider.setAttribute('max', '100')
                                        volumeSlider.setAttribute('value', '100')

                                        const mute = document.createElement('button')
                                        mute.setAttribute('class', 'mute-icon')
                                        finalDiv.appendChild(outputVolume)
                                        finalDiv.appendChild(seekSlider)
                                        finalDiv.appendChild(volumeSlider)
                                        finalDiv.appendChild(mute)

                                        //now that everything is created, i can use them for the animations and functionality
                                        let playState = 'play';
                                        let muteState = 'unmute';

                                        const playAnimation = lottieWeb.loadAnimation({
                                            container: buttonPlay,
                                            path: 'https://maxst.icons8.com/vue-static/landings/animated-icons/icons/pause/pause.json',
                                            renderer: 'svg',
                                            loop: false,
                                            autoplay: false,
                                            name: "Play Animation",
                                        })

                                        playAnimation.goToAndStop(14, true);

                                        buttonPlay.addEventListener('click', () => {
                                            if(playState === 'play') {
                                                playState = 'pause';
                                                audioPlay.play();
                                                playAnimation.playSegments([14, 27], true);
                                                requestAnimationFrame(whilePlaying);
                                                
                                            } else {
                                                playState = 'play';
                                                audioPlay.pause();
                                                playAnimation.playSegments([0, 14], true);
                                                cancelAnimationFrame(raf);
                                                
                                            }
                                        });

                                        //mute

                                        const muteAnimation = lottieWeb.loadAnimation({
                                            container: mute,
                                            path: 'https://maxst.icons8.com/vue-static/landings/animated-icons/icons/mute/mute.json',
                                            renderer: 'svg',
                                            loop: false,
                                            autoplay: false,
                                            name: "Mute Animation",
                                        });
                                    
                                        mute.addEventListener('click', () => {
                                            if(muteState === 'unmute') {
                                                muteAnimation.playSegments([0, 15], true);
                                                audioPlay.muted = true;
                                                muteState = 'mute';
                                            } else {
                                                muteAnimation.playSegments([15, 25], true);
                                                audioPlay.muted = false;
                                                muteState = 'unmute';
                                            }
                                        });

                                        //volume controller
                                        volumeSlider.addEventListener('input', (e) => {
                                            showRangeProgress(e.target);
                                        });
                                    
                                        volumeSlider.addEventListener('input', (e) => {
                                            const value = e.target.value;
                                            outputVolume.textContent = value;
                                            audioPlay.volume = value / 100;
                                        });

                                    }); //end foreach


                                })

            }else{
                console.log('the data could not be found!')

                //create a p with a message to the user
                const p = document.createElement('p')
                p.innerHTML = 'Hola, hubo un error y las radios no pudieron ser cargadas, intentalo mas tarde'
                encabezado.appendChild(p)

            }

        })
