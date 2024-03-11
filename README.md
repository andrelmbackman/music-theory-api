# Music Theory API

This API provides a simple interface for retrieving notes in different scales based on a given key.

## Usage

### Endpoints

The API currently responds to the following GET requests:

- `/scales/[key]/[scale_type]/notes`

  Retrieves a list of notes in the specified scale for the given key.

  - `key`: A musical key, represented as any of the following:
    - "C", "Cb", "C#", "Db", "D", "D#", "Eb", "E", "F", "F#", "Gb", "G", "G#", "Ab", "A", "A#", "Bb", "B"
    - '#' should be 'sharp' and 'b' should be 'flat'. Example: Fsharp, Bflat. 
  - `scale_type`: The type of scale, which can be either "major" or "minor".
  - Certain key and scale combinations will be altered to return the scale with the least key signatures. For example: Db minor will return C# minor.

### Example

To retrieve the notes in the C# minor scale, you can make a GET request to:

``0.0.0.0:8080/scales/Csharp/minor/notes``


## TODO
- Get the notes of a given key and scale [x]
- Get the chords of a given key and scale [ ]
- Return a random chord progression for a given key and scale [ ]

